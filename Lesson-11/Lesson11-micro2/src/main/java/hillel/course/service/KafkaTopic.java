package hillel.course.service;

public enum KafkaTopic {
    TOPIC1("calcSumma"),
    TOPIC2("statusSumma");

    private final String topicName;

    KafkaTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
