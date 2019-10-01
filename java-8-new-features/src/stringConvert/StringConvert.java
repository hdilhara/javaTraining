package stringConvert;

public class StringConvert {

    public static void main(String[] args) {

        Object object="thilina";

        String str=new String();

        str=(String)object;

        Object ob=15;

        str=ob.toString();

        str=String.valueOf(ob);

        if(ob instanceof String && ob!=null){
            str=(String)ob;
        }
        else if(ob!=null)
        {str=ob.toString();}
        else
            str=String.valueOf(ob);
    }
}
