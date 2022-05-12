package jaefact.branchtest.ListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {



    @org.junit.jupiter.api.Test
    void call(){
        List<Hello> helloList = new ArrayList<>();
        Hello hello1 = new Hello("홍길동");
        Hello hello2 = new Hello("홍길동2");
        Hello hello3 = new Hello("홍길동3");
        Hello hello4 = new Hello("홍길동4");
        Hello hello5 = new Hello("홍길동5");

        helloList.add(hello1);
        helloList.add(hello2);
        helloList.add(hello3);
        helloList.add(hello4);
        helloList.add(hello5);

        soutNames(helloList);
    }


    void soutNames(List<Hello> helloList){
        List<String> names = helloList.stream().map(Hello::getName).collect(Collectors.toList());
        names.forEach(name -> {
            System.out.println(name);
        });
    }
}

class Hello{
    String name;

    public Hello(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
