package com.hyuj.feelendar.calendar.decorator;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.hyuj.feelendar.domain.Feel;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

public class FeelDayDecorator implements DayViewDecorator {
        private final Drawable drawable;
        private Feel feel;
        private HashSet<CalendarDay> dates;

        public FeelDayDecorator(Feel feel, Collection<CalendarDay> dates, Activity context) {
            this.feel = feel;
            this.drawable = context.getResources().getDrawable(feel.getResourceId());
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
//            view.addSpan(new StyleSpan(Typeface.BOLD));
//            view.addSpan(new RelativeSizeSpan(1.4f));
//            view.addSpan(new ForegroundColorSpan(Color.GREEN));
            view.setSelectionDrawable(drawable);
        }
}
