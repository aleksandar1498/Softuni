package mood;

public class Archangel extends CharacterImpl<String>  {
    private int mana;
    public Archangel(String username, int level, int mana) {
        super(username, level);
        super.setHashedPassword((String) this.hashPassword(username));
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    @Override
    public Object hashPassword(String username) {
        StringBuilder builder=new StringBuilder(username);
        builder.reverse().append(username.length()*21);
        return builder.toString();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append(String.format("%d",this.getMana()*super.getLevel()));
        return builder.toString();
    }


}
