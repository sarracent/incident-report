/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author harold
 */
public class Estadisticas {
    private final PieChartModel model;
    public Estadisticas() {
model = new PieChartModel();
model.set("Brand 1", 540);
model.set("Brand 2", 325);
model.set("Brand 3", 702);
model.set("Brand 4", 421);
model.setTitle("Simple Pie");
model.setLegendPosition("w");
}
public PieChartModel getModel() {
return model;
}
}
