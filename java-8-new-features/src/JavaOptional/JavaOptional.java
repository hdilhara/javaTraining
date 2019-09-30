package JavaOptional;

import java.util.Optional;

public class JavaOptional {

    public static void main(String[] args) {
        Optional<String> ostr=Optional.empty();//private constructor

        ostr=Optional.of("Thilina");
        if(ostr.isPresent())
        System.out.println(ostr.get());

        Optional<String> os=Optional.empty();
        String str=new String();
        str="dilhara";
        os=Optional.ofNullable(str);
        System.out.println(os.get().toUpperCase());
        System.out.println(os.orElse("Thilina").toUpperCase());
    }
}
