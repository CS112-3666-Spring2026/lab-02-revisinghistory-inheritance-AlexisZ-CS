/**
 * RevisedHistoricalEvent.java
 */

public class RevisedHistoricalEvent extends HistoricalEvent {

    // Constants
    public static final String DEFAULT_REVISED_DESCRIPTION =
            "Revised historical event description default.";

    public static final String DEFAULT_CITATION =
            "Academic resource/citation.";

    // Instance Variables
    private String revisedDescription;
    private String citation;

    // Constructors

    public RevisedHistoricalEvent(String description,
                                  Date eventDay,
                                  String revisedDescription,
                                  String citation) {

        super(description, eventDay);

        this.setRevisedDescription(revisedDescription);
        this.setCitation(citation);
    }

    public RevisedHistoricalEvent() {

        this(HistoricalEvent.DEFAULT_DESCRIPTION,
                HistoricalEvent.DEFAULT_EVENT_DAY,
                DEFAULT_REVISED_DESCRIPTION,
                DEFAULT_CITATION);
    }

    public RevisedHistoricalEvent(RevisedHistoricalEvent original) {

        super(original);

        if (original != null) {

            this.setRevisedDescription(original.revisedDescription);
            this.setCitation(original.citation);

        } else {

            System.out.println("ERROR: null data given to copy constructor");
            System.exit(0);
        }
    }

    // Setters / Mutators

    public void setRevisedDescription(String revisedDescription) {
        this.revisedDescription = revisedDescription;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public boolean setAll(String description,
                          Date eventDay,
                          String revisedDescription,
                          String citation) {

        if (super.setAll(description, eventDay)) {

            this.setRevisedDescription(revisedDescription);
            this.setCitation(citation);

            return true;
        }

        return false;
    }

    // Getters / Accessors

    public String getRevisedDescription() {
        return this.revisedDescription;
    }

    public String getCitation() {
        return this.citation;
    }

    // Other Required Methods

    @Override
    public String toString() {

        return "The following \"history\" was told for many years:\n\n"
                + super.toString()
                + "\n\nBy correcting history, not just rewriting it, "
                + "we are revising it to embark on the process of righting a wrong.\n"
                + "Here is the revised history:\n"
                + this.revisedDescription
                + "\n\nSource: "
                + this.citation;
    }

    @Override
    public boolean equals(Object other) {

        if (other == null) {

            return false;

        } else if (this.getClass() != other.getClass()) {

            return false;

        } else {

            RevisedHistoricalEvent otherEvent =
                    (RevisedHistoricalEvent) other;

            return super.equals(other)
                    && this.revisedDescription.equals(otherEvent.revisedDescription)
                    && this.citation.equals(otherEvent.citation);
        }
    }

    public void teach() {
        System.out.println(this.toString());
    }
}