public class MainString {

    public static void main(String[] args) {
        String[] stringArr = new String[]{"1", "2", "3"};
        // dont use concatenate "+" in loops
        StringBuilder builder = new StringBuilder();
        for (String s : stringArr) {
            builder.append(s).append(" ");
        }
        System.out.println(builder.toString());

        String s1 = "abc";
        String s3 = "c";
        String s2 = ("ab" + s3).intern(); // add s2 to StringPool
        System.out.println(s1 == s2);
    }

}
