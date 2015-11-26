package app.view

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.server.FontAwesome
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE
import static com.vaadin.shared.ui.datefield.Resolution.DAY
import static java.util.Locale.TAIWAN
import javax.annotation.PostConstruct

/**
 * Created by nick on 2015/11/26.
 */
@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    private TabSheet queryBox
    private DateField yieldFromDate
    private DateField yieldTillDate
    private Button yieldQueryButton

    @PostConstruct
    void init() {

        queryBox = new TabSheet()

        queryBox.with {
            icon = FontAwesome.SEARCH
            caption = '台中區綜合查詢系統'
            setWidth(30, PERCENTAGE)
            setHeightUndefined()
            immediate = true

            addStyleName(ValoTheme.TABSHEET_FRAMED)
            addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR)
        }


        final VerticalLayout yieldTabContent = new VerticalLayout()
        // 查詢起日
        yieldFromDate = new PopupDateField('起始日期')

        yieldFromDate.with {
            resolution = DAY
            locale = TAIWAN
            textFieldEnabled = false
            value = new Date()
            immediate = true
            tabIndex = 6
        }

        // 查詢訖日
        yieldTillDate = new PopupDateField('截止日期')

        yieldTillDate.with {
            resolution = DAY
            locale = TAIWAN
            textFieldEnabled = false
            value = new Date()
            immediate = true
            tabIndex = 7
        }

        yieldQueryButton = new Button('產量查詢', { clickEvent ->
            fireQueryYield()
        } as Button.ClickListener)

        yieldTabContent.with {
            addComponent(yieldFromDate)
            setComponentAlignment(yieldFromDate, Alignment.MIDDLE_CENTER)
            addComponent(yieldTillDate)
            setComponentAlignment(yieldTillDate, Alignment.MIDDLE_CENTER)
            addComponent(yieldQueryButton)
            setComponentAlignment(yieldQueryButton, Alignment.MIDDLE_CENTER)
            setMargin(true)
            setSpacing(true)
        }

        // 放到 TabSheet 上
        queryBox.addTab(yieldTabContent, '產量查詢', FontAwesome.BAR_CHART_O)

        addComponent(queryBox);
        setComponentAlignment(queryBox, Alignment.MIDDLE_CENTER)
    }

    private void fireQueryYield() {
        //todo
        def nick = 1


    }

    @Override
    public void enter(ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}