import java.util.ArrayList;

public class Node {
    private NodeType type;
    private double value = 0.0;
    private String id = "";
    private ArrayList<Node> children = new ArrayList<>();
    private String modifiers;

    public Node(NodeType type, double value, String id) {
        this.type = type;
        this.value = value;
        this.id = id;
    }
    
    public Node(NodeType type) {
        this.type = type;
    }

    public void attach(Node child) {
        if (child != null) {
            children.add(child);
        }
    }
    
    public NodeType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public String getID() {
        return id;
    }
   
    public void setModifiers(String modifiers) {
        this.modifiers = modifiers;
    }
    
    public int numChildren() {
        return children.size();
    }

    public void print(int levels) {
        for (int i = 0; i < levels; i++) {
            System.out.print("    ");
        }

        switch(type) {
            case QualifiedName:
                System.out.printf("Qualified Name: %s\n", id);
                break;
            case Identifier:
                System.out.printf("Id: %s\n", id);
                break;
            case Import:
                System.out.printf("Import: %s\n", id);
                break;
            case Package:
                System.out.printf("Package: %s\n", id);
                break;
            case IntValue:
                System.out.printf("Value: %f\n", value);
                break;
            default:
                System.out.println(type.toString());
        }

        for (Node child : children) {
            child.print(levels + 1);
        }
    }

    public void print() {
        print(0);
    }
}

