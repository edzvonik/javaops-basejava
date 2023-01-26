import com.dzvonik.webapp.model.Resume;

import java.lang.reflect.Field;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredField("uuid");
        field.setAccessible(true);
        System.out.println(field.getName());
        String newUuid = "Changed uuid";
        System.out.println(resume.getUuid());
        field.set(resume, newUuid);
        System.out.println(resume.getUuid());
    }

}
