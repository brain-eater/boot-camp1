package boot_camp.Logger;

public class Console implements Logable, Printable {
    private String data = "";
    private String delimiter = "";


    @Override
    public boolean addLog(String log) {
        data = data.concat(delimiter + log);
        delimiter = "\n";
        return true;
    }

    @Override
    public String print() {
        return data;
    }
}
