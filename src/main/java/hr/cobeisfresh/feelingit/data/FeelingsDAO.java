package hr.cobeisfresh.feelingit.data;

import java.util.List;

public interface FeelingsDAO {

    boolean addMyFeeling(Feeling feeling);

    boolean removeMyFeeling(Feeling feeling);

    void clearMyFeelings();

    List<Feeling> getMyFeelings();

    List<Feeling> getAllFeelings();
}
