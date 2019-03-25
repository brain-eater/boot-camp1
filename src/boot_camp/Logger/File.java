package boot_camp.Logger;

public class File implements Logable, Printable {
    private String data;


    @Override
    public boolean addLog(String log) {
        data = data.concat("\n" + log);
        return true;
    }

    @Override
    public String print() {
        return data;
    }
}
