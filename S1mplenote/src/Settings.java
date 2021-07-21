public class Settings {
    private boolean sort;
    private boolean sync;

    public Settings(boolean sort, boolean sync) {
        this.sort = sort;
        this.sync = sync;
    }

    public boolean getSort() {
        return sort;
    }

    public void setSort(boolean sort) {
        this.sort = sort;
    }

    public boolean getSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public void showConfig() {
        System.out.println("Ordenar:" + sort);
        System.out.println("Sincronizar:" + sync);
    }
}