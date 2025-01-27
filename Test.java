import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;


public class Test {
    public static void main(String[] args) {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.center);

        Table t = new Table(8, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        t.setColumnWidth(0, 20, 20);
        t.setColumnWidth(1, 20, 20);
        t.setColumnWidth(2, 20, 20);
        t.setColumnWidth(3, 20, 20);
        t.setColumnWidth(4, 20, 20);
        t.setColumnWidth(5, 20, 20);
        t.setColumnWidth(6, 20, 20);
        t.setColumnWidth(7, 20, 20);


        t.addCell("Region", numberStyle);
        t.addCell("Orders", numberStyle);
        t.addCell("Sales", numberStyle);
        t.addCell("Region", numberStyle);
        t.addCell("Orders", numberStyle);
        t.addCell("Sales", numberStyle);
        t.addCell("Sales", numberStyle);
        t.addCell("Sales", numberStyle);

        t.addCell("Region", numberStyle);


//        t.addCell("Total", numberStyle);
//        t.addCell("$172.646", numberStyle);

        System.out.println(t.render());

    }
}
