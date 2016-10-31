package old.java.Enums;

/**
 * Created by pandita on 9/26/2015.
 */
public enum level {
    HIGH (1),
    MEDIUM(2),
    LOW(3);

    private final int levelCode;

    private level(int levelCode) {
        this.levelCode = levelCode;
    }

    public static void main(String args[]){
        level l = level.HIGH;
        System.out.println(l.getLevelCode());
        l=level.LOW;
        System.out.println(l.getLevelCode());
        l=level.MEDIUM;
        System.out.println(l.getLevelCode());
    }

    public int getLevelCode() {
        return levelCode;
    }
}

