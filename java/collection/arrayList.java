

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class arrayList {
    //arrayList is a collect that they using it more for stor data list
    //ArrayList គឺជា Collection ដែលប្រើញឹកញាប់សម្រាប់រក្សាទុកបញ្ជីទិន្នន័យ។
    public static void main(String[] args) {
      
        ArrayList<String> student =new ArrayList<>();
        student.add("Vibol");
        student.add("dara");
        student.add("darika");
        System.out.println(student);
        student.add("kususus");
        student.add("kakakak");
        System.out.println(student);
        List<Map<String,Object>> Teacher = new ArrayList<>();
        Teacher.add(
            Map.of(
                "name","vibol",
                "age",19,
                "Gender","Male"
            )
        );
        System.out.println(Teacher);
          System.out.println(Arrays.toString(args));
    }
}
