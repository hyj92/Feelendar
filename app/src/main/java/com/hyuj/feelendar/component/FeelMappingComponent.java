package com.hyuj.feelendar.component;

import com.hyuj.feelendar.domain.Feel;
import com.hyuj.feelendar.helper.SQLiteAccessHelper;

import java.util.List;

public class FeelMappingComponent {

    private static class FeelMappingHolder {
        public static final FeelMappingComponent feelMappingComponent = new FeelMappingComponent();
    }

    /**
     * 컴포넌트 인스턴스를 가져오는 메소드입니다.(싱글톤 패턴)
     * @return FeelMappingComponent
     * */
    public static FeelMappingComponent getInstance(){
        return FeelMappingHolder.feelMappingComponent;
    }

    // 바깥에서 생성을 방지하기위해 생성자를 private으로 지정했습니다.
    private FeelMappingComponent(){}

    /**
     * feel resourceId를 내려주는 메소드입니다.
     * feelList 를 멤버변수로 가지고 어디서든 feelName만 알면 사용하게 하려고 했지만,
     * DB접근은 context가 있을 때만 가능하기 때문에, activity에서 feel List를 관리하고, 맵핑하는 메소드만
     * 이 컴포넌트에서 사용하게 했습니다.
     * 더 좋은 방법이 있으면 바꾸었으면 좋겠습니다.
     * */
    // 만약 runtime 시에 새로운 resource를 만들고 이를 feel로 만든다면, R.drawable.class.getField()로 resource id 를 가져와야 합니다.
    public int getResourceId(List<Feel> feelList, String feelName){
        for(Feel feel : feelList){
            if(feel.getName().equals(feelName)){
                return feel.getResourceId();
            }
        }
        return 0;
    }
}
