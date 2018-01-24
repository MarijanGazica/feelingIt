package hr.cobeisfresh.feelingit.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeelingsDAOImpl implements FeelingsDAO {

    private List<Feeling> allFeelings = generateFeelings();
    private Set<Feeling> myFeelings = new HashSet<>();


    @Override
    public boolean addMyFeeling(Feeling feeling) {
        if (allFeelings.contains(feeling)) {
            return myFeelings.add(feeling);
        } else throw new FeelingNotSupportedException();
    }

    @Override
    public boolean removeMyFeeling(Feeling feeling) {
        if (myFeelings.contains(feeling)) {
            return myFeelings.remove(feeling);
        } else throw new FeelingNotSupportedException();
    }

    @Override
    public void clearMyFeelings() {
        myFeelings.clear();
    }

    @Override
    public List<Feeling> getMyFeelings() {
        return new ArrayList<>(myFeelings);
    }

    @Override
    public List<Feeling> getAllFeelings() {
        return new ArrayList<>(allFeelings);
    }

    private List<Feeling> generateFeelings() {
        List<Feeling> list = new ArrayList<>();
        list.add(new Feeling("Anger", 0));
        list.add(new Feeling("Happiness", 1));
        list.add(new Feeling("Laziness", 0));
        list.add(new Feeling("Satisfaction", 1));
        list.add(new Feeling("Love", 1));
        list.add(new Feeling("Disappointment", 0));
        return list;
    }
}
