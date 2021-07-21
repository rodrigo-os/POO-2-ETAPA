public class Tag {
    private String name;
    private int numTags = 0;

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumTags() {
        return numTags;
    }

    public void setNumTags(int numTags) {
        this.numTags = numTags;
    }

    public void amountTag() {
        System.out.println();
        System.out.println("Existem " + numTags + " Tag's cadastradas no momento!");
    }
}