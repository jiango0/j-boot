package com.jzc.spring.boot.test.algorithm;

/**
 * 【程序18】   题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程

 * */
public class Problem02 {

    String[] team_1 = new String[] {"a", "b", "c"};
    String[] team_2 = new String[] {"x", "y", "z"};


    public void problem() {
        for(int i=0; i<team_1.length; i++) {
            for(int k=0; k<team_2.length; k++) {

                if("a".equals(team_1[i]) && "x".equals(team_2[k])
                        || "a".equals(team_1[i]) && "y".equals(team_2[k]) ) {
                    continue;
                }  else if("c".equals(team_1[i])  && "x".equals(team_2[k])
                        || "c".equals(team_1[i])  && "z".equals(team_2[k]) ) {
                    continue;
                } else if("b".equals(team_1[i])  && "z".equals(team_2[k])
                        || "b".equals(team_1[i])  && "y".equals(team_2[k]) ) {
                    continue;
                } else {
                    System.out.println( team_1[i] + " vs " + team_2[k] );
                }

            }
        }
    }

}
