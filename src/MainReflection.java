import com.dzvonik.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredField("uuid");
        field.setAccessible(true);
        System.out.println(field.getName());
        String newUuid = "Changed uuid";
        System.out.println(resume.getUuid());
        field.set(resume, newUuid);
        System.out.println(resume.getUuid());
        // TODO: Invoke toString() with Reflection API
        Method toStringMethod = resume.getClass().getDeclaredMethod("toString");
        String resumeString = (String) toStringMethod.invoke(resume);
        System.out.println(resumeString);
    }

}
