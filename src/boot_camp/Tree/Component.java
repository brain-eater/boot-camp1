package boot_camp.Tree;

import java.util.ArrayList;
import java.util.List;

public class Component {
    List<Component> children = new ArrayList<>();
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public void addChild(Component child) {
        this.children.add(child);
    }

    public String refresh() {
        String msg = this.name + " refreshed.\n";
        for (Component child : children) {
            msg = msg.concat(child.refresh());
        }
        return msg;
    }

}
