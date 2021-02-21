package com.example.javase;


import com.google.common.base.Joiner;
import lombok.Data;
import net.minidev.json.JSONArray;
import org.assertj.core.util.Lists;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommitDemo {
    public static void main(String[] args) throws IOException {

        List<Map<String, String>> list = new ArrayList<>();


        File file = new File("filename.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Stream<String> lines = reader.lines();

        List<String> collect = lines.filter(s -> s != null && !s.isEmpty() && !s.startsWith("-\t-")).collect(Collectors.toList());

        CommitInfo commitInfo = null;
        List<CommitInfo> commitInfos = Lists.newArrayList();

        List<List<String>> allCommits = Lists.newArrayList();
        listSplit(collect, allCommits);


        //解析
        for (String str : collect) {

            if (str.startsWith("commit")) {
                commitInfo = new CommitInfo();

                String[] s = str.split(" ");
                commitInfo.setCommit(s[s.length - 1]);
            }
            if (str.startsWith("Author")) {
                String[] s = str.split(": ");
                commitInfo.setAuthor(s[s.length - 1]);
            }
            if (str.startsWith("Date")) {
                String[] s = str.split(": ");
                commitInfo.setDate(s[s.length - 1]);
                commitInfos.add(commitInfo);
            }
            if (str.startsWith("Merge:")) {
                String[] s = str.split(": ");
                commitInfo.setMerge(s[s.length - 1]);
                commitInfos.add(commitInfo);
            }
            //todo
            //1.正则匹配+{数值开始\t+路径+后缀}
            //2.字符串切分，length==3
//            if (str.s){
//
//            }
        }
        List<String> strings = Lists.newArrayList();
        while (reader.ready()) {
            String line = reader.readLine();
            if (line != null && line != "" && !line.startsWith("-\t-")) {
                line.trim();
                Map<String, String> hashMap = new HashMap<>();
                matching(line, hashMap, "commit", " ");
                matching(line, hashMap, "Author", ": ");
                matching(line, hashMap, "Date", ": ");
                if (!hashMap.isEmpty()) {
                    list.add(hashMap);
                }
                strings.add(line);
            }
        }
        String arrString = JSONArray.toJSONString(list);

        strings.forEach(str -> System.err.println("str = " + str));
        System.out.println("===");


    }

    private static void listSplit(List<String> collect, List<List<String>> allCommits) {
        //        切分
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).startsWith("commit")) {
                String join = Joiner.on("").join(collect);
                String trim = join.trim();
                String[] commit = trim.split("commit ");
                for (String str : commit) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
                    BufferedReader readers = new BufferedReader(new InputStreamReader(byteArrayInputStream));
                    Stream<String> lines1 = readers.lines();
                    List<String> collect1 = lines1.filter(s -> s != null && !s.isEmpty() && !s.startsWith("-\t-")).collect(Collectors.toList());
                    allCommits.add(collect1);
                }
                return;
            }
        }
    }

    private static void matching(String line, Map<String, String> hashMap, String date, String s2) {
        if (line.startsWith(date)) {
            String[] s = line.split(s2);
            if (s != null && s.length == 2) {
                hashMap.put(date, s[s.length - 1]);
            }


        }
    }


}

@Data
class CommitInfo {

    private String commit;
    private String Author;
    private String Date;
    private String Merge;
    List<FileInfo> fileInfoList;
}

@Data
class FileInfo {
    private String inserted;
    private String deleted;
    private String filePath;
}