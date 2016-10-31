package old.java.UnsafeClass;

/**
 * Created by pandita on 8/6/2015.
 */

//reference: http://mishadoff.com/blog/java-magic-part-4-sun-dot-misc-dot-unsafe/
import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class TryUnsafeClassImpl {

    private static int apple = 11;
    private int orange = 10;
    private final int banana =90;

    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafeInstance();

        Field appleField = TryUnsafeClassImpl.class.getDeclaredField("apple");
        System.out.println("Location of Apple: "
                + unsafe.staticFieldOffset(appleField));

        Field orangeField = TryUnsafeClassImpl.class.getDeclaredField("orange");
        System.out.println("Location of Orange: "
                + unsafe.objectFieldOffset(orangeField));

        Field bananaField = TryUnsafeClassImpl.class.getDeclaredField("banana");
        System.out.println("Location of Banana: "
                + unsafe.objectFieldOffset(bananaField));
    }

    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}