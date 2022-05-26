import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericTreeNode {

    public T data;
    public List children;

    public GenericTreeNode() {
        super();
        children = new ArrayList();
    }

    public GenericTreeNode(T data) {
        this();
        setData(data);
    }

    public List  getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public void addChild(GenericTreeNode child) {
        children.add(child);
    }

    public void addChildAt(int index, GenericTreeNode child) throws IndexOutOfBoundsException {
        children.add(index, child);
    }

    public void removeChildren() {
        this.children = new ArrayList ();
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public GenericTreeNode getChildAt(int index) throws IndexOutOfBoundsException {
        return children.get(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }

    public boolean equals(GenericTreeNode node) {
        return node.getData().equals(getData());
    }

    public int hashCode() {
        return getData().hashCode();
    }

    public String toStringVerbose() {
        String stringRepresentation = getData().toString() + ":[";

        for (GenericTreeNode node : getChildren()) {
            stringRepresentation += node.getData().toString() + ", ";
        }

//Pattern.DOTALL causes ^ and $ to match. Otherwise it won't. It's retarded.
        Pattern pattern = Pattern.compile(", $", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(stringRepresentation);

        stringRepresentation = matcher.replaceFirst("");
        stringRepresentation += "]";

        return stringRepresentation;
    }
}