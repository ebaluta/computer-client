package app;

//MUSIMY MIEĆ TEN MODEL TUTAJ SKORO CHCMY DOSTAWAĆ TE ELEMENTY
public class Computer {

    private long id;
    private String ddrType;
    private long mhz;
    private int memorySize;

    public Computer() {
    }

    public Computer(long id, String ddrType, long mhz, int memorySize) {
        this.id = id;
        this.ddrType = ddrType;
        this.mhz = mhz;
        this.memorySize = memorySize;
    }

    public String getDdrType() {
        return ddrType;
    }

    public void setDdrType(String ddrType) {
        this.ddrType = ddrType;
    }

    public long getMhz() {
        return mhz;
    }

    public void setMhz(long mhz) {
        this.mhz = mhz;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Metoda toString musi być aby JSON się wyświetlał ładnie

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", ddrType='" + ddrType + '\'' +
                ", mhz=" + mhz +
                ", memorySize=" + memorySize +
                '}';
    }
}
