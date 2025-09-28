import java.util.ArrayList;
import java.util.List;

// --- Component Interface ---
interface FileSystemComponent {
    void showDetails();
}

// --- Leaf Class ---
class File implements FileSystemComponent {
    private String name;
    public File(String name) { this.name = name; }

    @Override
    public void showDetails() {
        System.out.println("  File: " + name);
    }
}

// --- Composite Class ---
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) { this.name = name; }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails(); // Recursively call showDetails
        }
    }
}

// --- Demo ---
public class CompositePattern {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory pictures = new Directory("pictures");

        File file1 = new File("resume.pdf");
        File file2 = new File("photo.jpg");
        File file3 = new File("report.docx");

        root.addComponent(documents);
        root.addComponent(pictures);
        documents.addComponent(file1);
        documents.addComponent(file3);
        pictures.addComponent(file2);

        // Treat the entire tree uniformly
        root.showDetails();
    }
}