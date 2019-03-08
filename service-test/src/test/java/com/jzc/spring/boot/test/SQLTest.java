package com.jzc.spring.boot.test;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.postgresql.visitor.PGSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class SQLTest {

    private String sql = "select " +
            "oa.order_code as o1, " +
            "oa.order_name o2, " +
            "oa.order_status o3, " +
            "oi.order_item_code, " +
            "oi.item_name, " +
            "op.promotion_code, " +
            "op.promotion_fee, " +
            "sum(op.promotion_fee), " +
            "count(1) " +
            "from orders oa " +
            "left join order_item oi on oa.order_code = oi.order_code " +
            "left join order_promotion op on oi.order_code = op.order_code " +
            "where oa.order_code = 'BG3FED01957688411' ";

    private String sql2 = "select level ll, name, parentId, status from t_areainfo";

    @Test
    public void sql() {

        String dbType = JdbcConstants.POSTGRESQL;

        String format = SQLUtils.format(sql2, dbType);
        System.out.println("format ：");
        System.out.println(format);

        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql2, dbType);
        System.out.println("stmtList:" + JSON.toJSONString(stmtList));
        System.out.println("stmtList size:" + stmtList.size());
        for (int i = 0; i < stmtList.size(); i++) {
            SQLStatement stmt = stmtList.get(i);

            PGSchemaStatVisitor visitor = new PGSchemaStatVisitor();
            stmt.accept(visitor);
            Map<String, String> aliasmap = visitor.getAliasMap();

            for (Iterator iterator = aliasmap.keySet().iterator(); iterator.hasNext();) {
                String key = iterator.next().toString();
                System.out.println("[ALIAS]" + key + " - " + aliasmap.get(key));
            }
            Set<TableStat.Column> groupby_col = visitor.getGroupByColumns();
            //
            for (Iterator iterator = groupby_col.iterator(); iterator.hasNext();) {
                TableStat.Column column = (TableStat.Column) iterator.next();
                System.out.println("[GROUP]" + column.toString());
            }
            //获取表名称
            System.out.println("table names:");
            Map<TableStat.Name, TableStat> tabmap = visitor.getTables();
            for (Iterator iterator = tabmap.keySet().iterator(); iterator.hasNext();) {
                TableStat.Name name = (TableStat.Name) iterator.next();
                System.out.println(name.toString() + " - " + tabmap.get(name).toString());
            }
            //System.out.println("Tables : " + visitor.getCurrentTable());
            //获取操作方法名称,依赖于表名称
            System.out.println("Manipulation : " + visitor.getTables());
            //获取字段名称
            System.out.println("fields : " + visitor.getColumns());


        }

    }

}
