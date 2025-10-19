package student;

public class Subject {
    private static int nextId = 1;
    private int id;
    private String code;
    private String title;

    public Subject() {
        this.id = nextId++;
    }
    public Subject(String code, String title) {
        this.id = nextId++;
        this.code = code;
        this.title = title;
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    public String normalizedCode() {
        return code == null ? null : code.trim().toUpperCase();
    }

    public String properTitle() {
        if (title == null || title.isEmpty()) return title;
        String[] words = title.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1).toLowerCase())
                    .append(" ");
        }
        return sb.toString().trim();
    }

    public boolean isIntroCourse() {
        if (title == null && code == null) return false;
        String t = title == null ? "" : title.toLowerCase();
        String c = code == null ? "" : code.toUpperCase();
        return t.contains("intro") || c.startsWith("INTRO-");
    }

    public String syllabusLine(Instructor instructor) {
        StringBuilder sb = new StringBuilder();
        sb.append(normalizedCode())
                .append(" - ")
                .append(properTitle())
                .append(" (Instructor: ");
        if (instructor != null)
            sb.append(instructor.displayName());
        else
            sb.append("TBA");
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Subject[id=%d, code=%s, title=%s]", id, normalizedCode(), properTitle());
    }
}
