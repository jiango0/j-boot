package com.jzc.spring.boot.test;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.postgresql.visitor.*;
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
            "op.promotion_fee pf, " +
            "sum(op.promotion_fee) ss, " +
            "count(1) " +
            "from orders oa " +
            "left join order_item oi on oa.order_code = oi.order_code " +
            "left join order_promotion op on oi.order_code = op.order_code " +
            "where oa.order_code = 'BG3FED01957688411' ";

    private String sql2 = "select level ll, name, parentId, status from t_areainfo ta";

    private String sql3 = "select t1.1 as 1, t1.2   2  , (select * from t4) tc, (select * from t4) t, t2.4 from t1 , (select * from t2) t2, (select * from t3) t3 where t1.1 = 1";

    @Test
    public void sql() {

        String dbType = JdbcConstants.MYSQL;

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

            PGASTVisitorAdapter v1 = new PGASTVisitorAdapter();
            stmt.accept(v1);

            PGEvalVisitor v2 = new PGEvalVisitor();
            stmt.accept(v2);

            PGExportParameterVisitor v3 = new PGExportParameterVisitor();
            stmt.accept(v3);

            PGParameterizedOutputVisitor v5 = new PGParameterizedOutputVisitor();
            stmt.accept(v5);

            PGSchemaStatVisitor v6 = new PGSchemaStatVisitor();
            stmt.accept(v6);



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

    @Test
    public void analyzeSql () {
        int index = sql3.length() -1;
        while (sql3.lastIndexOf("from", index -1) != -1) {
            index = sql3.lastIndexOf("from", index -1);
            int l = sql3.lastIndexOf("(", index);
            int r = sql3.lastIndexOf(")", index);

            if (l != -1 && r != -1 && l - r > 0) {
                continue;
            } else if (l != -1  && r == -1) {
                continue;
            }

            break;
        }

        String[] columnArr = sql3.substring(6, index).split("[,]");
        for(String column : columnArr) {
            column = column.trim();
            System.out.println("column : " + column);

            if (column.contains("as")) {
                String[] as = column.split("as");
                System.out.println("as : " + as[as.length -1]);
            }

            if (column.contains(" ")) {
                String[] split = column.split(" ");
                System.out.println("space : " + split[split.length -1]);
            }

        }

        System.out.println(sql3.substring(6, index));

    }

}
