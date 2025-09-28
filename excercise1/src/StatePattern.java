// --- Context Class ---
class Document {
    private State state;
    public Document() { state = new DraftState(this); } // Initial state
    public void changeState(State state) { this.state = state; }
    public void publish() { state.publish(); }
    public void approve() { state.approve(); }
}

// --- State Interface ---
interface State {
    void publish();
    void approve();
}

// --- Concrete States ---
class DraftState implements State {
    private Document document;
    public DraftState(Document doc) { this.document = doc; }
    public void publish() {
        System.out.println("Submitting document for moderation...");
        document.changeState(new ModerationState(document));
    }
    public void approve() { System.out.println("Cannot approve a draft."); }
}

class ModerationState implements State {
    private Document document;
    public ModerationState(Document doc) { this.document = doc; }
    public void publish() { System.out.println("Document is already in moderation."); }
    public void approve() {
        System.out.println("Document approved and published!");
        document.changeState(new PublishedState(document));
    }
}

class PublishedState implements State {
    private Document document;
    public PublishedState(Document doc) { this.document = doc; }
    public void publish() { System.out.println("Document is already published."); }
    public void approve() { System.out.println("Document is already published."); }
}

// --- Demo ---
public class StatePattern {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.approve(); // Fails: Cannot approve a draft
        doc.publish(); // Moves to Moderation
        doc.publish(); // Fails: Already in moderation
        doc.approve(); // Moves to Published
    }
}