package org.noahbuilds;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Item item1 = new Item();
        Item item2 = new Item();

        item1.setStimulus("The basic structural and functional unit of living organisms is the");


        Option option1 = new Option("system", false);
        Option option2 = new Option("organ", false);
        Option option3 = new Option("tissue", false);
        Option option4 = new Option("cell", true);

        List<Option> item1OptionList = new ArrayList<>(List.of(option1, option2, option3, option4));

//        item1OptionList.add(option1);
//        item1OptionList.add(option2);
//        item1OptionList.add(option3);
//        item1OptionList.add(option4);

        item1.setOptions(item1OptionList);


        item2.setStimulus("The site for cellular respiration and energy production in plant and animal cells is the");


        Option item2Option1 = new Option("lysosome", false);
        Option item2Option2 = new Option("mitochondrion", false);
        Option item2Option3 = new Option("ribosome", false);
        Option item2Option4 = new Option("vacuole", true);
        List<Option> item2OptionList = new ArrayList<>(List.of(item2Option1, item2Option2, item2Option3, item2Option4));

        item2.setOptions(item2OptionList);


//        String itemJson = gson.toJson(item1);
//        System.out.println("item json is " + itemJson);


        Topic topic1 = new Topic();
        topic1.setName("ECOLOGY");
        topic1.setItemType("MCQ");
        topic1.setItems(List.of(item2, item1));
        topic1.setRubric("");


        Topic topic2 = new Topic();
        topic2.setName("REPRODUCTION");
        topic2.setItemType("PASSAGE");
        topic2.setItems(List.of(item2, item1));
        topic2.setRubric("Read the question carefully and answer the question that follows");


        Subject subject = new Subject();

        subject.setName("BIOLOGY");
        subject.setCode("BIO");
        subject.setTopics(List.of(topic1, topic2));

        String subjectJson = gson.toJson(subject);
        System.out.println("subject json is " + subjectJson);


    }
}


//@Data
class Subject {

    private List<Topic> topics;
    private String name;
    private String code;

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }


}

//@Data
class Topic {

    private String name;
    private List<Item> items;
    private String itemType;
    private String rubric;

    public void setName(String name) {
        this.name = name;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setRubric(String rubric) {
        this.rubric = rubric;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}

//@Data
class Item {

    private String stimulus;
    private List<Option> options;

    public void setStimulus(String stimulus) {
        this.stimulus = stimulus;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }


}

//@Data
class Option {

    private final boolean answer;
    private final String label;

    public Option(String label, boolean answer) {
        this.label = label;
        this.answer = answer;
    }

}