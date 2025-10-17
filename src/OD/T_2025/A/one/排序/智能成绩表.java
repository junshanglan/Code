package OD.T_2025.A.one.排序;

import java.util.*;

public class 智能成绩表 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        // 学生数
        int sNum = Integer.parseInt(split[0]);
        // 课程数
        int kNum = Integer.parseInt(split[1]);
        List<String> subjects = Arrays.asList(scanner.nextLine().split(" "));
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < sNum; i++) {
            String[] s = scanner.nextLine().split(" ");
            String name = s[0];
            Map<String,Integer> subjectMap = new HashMap<>();
            for (int j = 1; j < s.length; j++) {
                subjectMap.put(subjects.get(j - 1), Integer.parseInt(s[j]));
            }
            studentList.add(new Student(name,subjectMap));
        }
        String cmpSubject = scanner.nextLine();
        if (subjects.contains(cmpSubject)) {
            for (Student student : studentList) {
                student.score = student.subjectMap.get(cmpSubject);
            }
        }else{
            for (Student student : studentList) {
                for (Map.Entry<String, Integer> item : student.subjectMap.entrySet()) {
                    student.score += item.getValue();
                }
            }
        }
        Collections.sort(studentList);
        for (Student student : studentList) {
            System.out.print(student.name + " ");
        }
    }
}
class Student implements Comparable<Student>{
    int score;
    String name;
    Map<String,Integer> subjectMap = new HashMap<>();
    Student(String name,Map<String,Integer> subjectMap){
        this.name = name;
        this.subjectMap = subjectMap;
    }
    @Override
    public int compareTo(Student student) {
        if (this.score == student.score) {
            return this.name.compareTo(student.name);
        }
        return student.score - this.score;
    }
}
