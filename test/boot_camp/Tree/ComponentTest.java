package boot_camp.Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComponentTest {
    @Test
    void shouldRefreshTheChildren() {
        Component body = new Component("Body");
        Component content = new Component("Content");
        content.addChild(new Component("Image"));
        content.addChild(new Component("Text"));
        body.addChild(content);
        body.addChild(new Component("SP"));
        body.addChild(new Component("BP"));
        String expected = "Body refreshed.\n" +
                "Content refreshed.\n" +
                "Image refreshed.\n" +
                "Text refreshed.\n" +
                "SP refreshed.\n" +
                "BP refreshed.\n";
      assertEquals(expected,body.refresh());
    }
}