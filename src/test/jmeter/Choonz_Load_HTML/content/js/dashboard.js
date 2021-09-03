/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 99.33637072795722, "KoPercent": 0.6636292720427798};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.6845386815596983, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.706058339566193, 500, 1500, "Read Genre"], "isController": false}, {"data": [0.5655065082059989, 500, 1500, "Update Playlist"], "isController": false}, {"data": [0.762748643761302, 500, 1500, "Read Album One"], "isController": false}, {"data": [0.48411843876177657, 500, 1500, "Read Playlist One"], "isController": false}, {"data": [0.6923909681410455, 500, 1500, "Delete Playlist"], "isController": false}, {"data": [0.6838693592620294, 500, 1500, "Read Genre One"], "isController": false}, {"data": [0.39656077710685217, 500, 1500, "Read Playlist"], "isController": false}, {"data": [0.44076564924987066, 500, 1500, "Create Playlist"], "isController": false}, {"data": [0.8265167007498296, 500, 1500, "Read Album"], "isController": false}, {"data": [0.5596733668341709, 500, 1500, "Read User One"], "isController": false}, {"data": [0.7970888280666832, 500, 1500, "Create Genre"], "isController": false}, {"data": [0.8513680059157013, 500, 1500, "Update Artist"], "isController": false}, {"data": [0.6663336663336663, 500, 1500, "Update Genre"], "isController": false}, {"data": [0.9026111503175723, 500, 1500, "Create Artist"], "isController": false}, {"data": [0.655875, 500, 1500, "Create User"], "isController": false}, {"data": [0.458386520296145, 500, 1500, "Update User"], "isController": false}, {"data": [0.7708873056994818, 500, 1500, "Create Album"], "isController": false}, {"data": [0.6731634182908546, 500, 1500, "Delete Genre"], "isController": false}, {"data": [0.7477499391875456, 500, 1500, "Read Artist One"], "isController": false}, {"data": [0.5239108662994492, 500, 1500, "Read User"], "isController": false}, {"data": [0.7652987760979122, 500, 1500, "Read Artist"], "isController": false}, {"data": [0.8518748447976161, 500, 1500, "Delete Artist"], "isController": false}, {"data": [0.871023380605596, 500, 1500, "Update Album"], "isController": false}, {"data": [0.9572158365261814, 500, 1500, "Delete Album"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 88453, 587, 0.6636292720427798, 933.9592778085537, 0, 13505, 1636.5, 4362.0, 4919.0, 6692.970000000005, 134.49266283399652, 2324.733985205929, 29.72282248920066], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["Read Genre", 4011, 0, 0.0, 951.2016953378203, 1, 9073, 172.0, 3405.6000000000004, 4187.5999999999985, 5034.920000000001, 6.592127904702582, 364.52768717345464, 1.1909606077831814], "isController": false}, {"data": ["Update Playlist", 3534, 2, 0.056593095642331635, 1258.4057724957534, 1, 10286, 848.0, 3532.5, 4189.0, 5754.000000000002, 7.1794538414344276, 2.5242529084000016, 2.066151101575864], "isController": false}, {"data": ["Read Album One", 2765, 400, 14.466546112115733, 338.6195298372507, 0, 10286, 3.0, 1197.6000000000004, 2653.499999999999, 4190.02, 6.131595345753232, 6.442458671328749, 1.1353530095544226], "isController": false}, {"data": ["Read Playlist One", 3715, 0, 0.0, 1491.4401076716026, 0, 10720, 1156.0, 3697.4, 4241.599999999999, 5854.720000000001, 7.160976437207007, 2.4665401448387, 1.347637576525105], "isController": false}, {"data": ["Delete Playlist", 3233, 0, 0.0, 893.5982060006186, 1, 8421, 28.0, 3153.9999999999995, 3928.5999999999995, 5460.499999999996, 6.708067317208797, 1.2512117749871876, 1.419339374415145], "isController": false}, {"data": ["Read Genre One", 4011, 0, 0.0, 947.7908252306158, 0, 7975, 39.0, 3339.0, 4078.0, 5054.440000000004, 6.648510756796449, 2.2189997749849577, 1.2318718889494822], "isController": false}, {"data": ["Read Playlist", 3809, 0, 0.0, 1796.4297715935925, 2, 10586, 1486.0, 4025.0, 4497.0, 6093.500000000002, 7.2814234810136265, 506.5726095702259, 1.3368238422173455], "isController": false}, {"data": ["Create Playlist", 3866, 0, 0.0, 1631.4081738230743, 0, 11664, 1243.5, 3896.6000000000004, 4377.849999999997, 5836.579999999998, 7.278752106338313, 2.5071879530392462, 2.0613653426153427], "isController": false}, {"data": ["Read Album", 2934, 0, 0.0, 555.4004771642808, 2, 9610, 107.0, 1838.5, 3211.25, 4479.0, 6.230000403442426, 278.47145618296753, 1.1255371822625475], "isController": false}, {"data": ["Read User One", 3980, 2, 0.05025125628140704, 1336.6080402010073, 0, 11067, 725.0, 3817.9, 4372.749999999999, 5976.130000000001, 7.162872563858448, 3.031329314078464, 1.320148458632611], "isController": false}, {"data": ["Create Genre", 4019, 1, 0.02488181139586962, 591.9238616571281, 0, 12168, 4.0, 2717.0, 3420.0, 4620.800000000003, 6.5172620688536815, 2.097348776999854, 1.68023162712634], "isController": false}, {"data": ["Update Artist", 4057, 0, 0.0, 435.4934680798592, 1, 11831, 3.0, 2014.4000000000033, 3184.0, 4542.200000000001, 6.271710212050897, 1.8480522113691558, 1.4621950401199306], "isController": false}, {"data": ["Update Genre", 4004, 1, 0.024975024975024976, 1025.3416583416592, 1, 11189, 64.0, 3447.5, 4162.5, 5510.749999999995, 6.718301162447314, 2.137198864608781, 1.7631063973613383], "isController": false}, {"data": ["Create Artist", 4251, 0, 0.0, 274.3116913667367, 0, 7415, 3.0, 895.4000000000005, 2281.399999999996, 3656.399999999976, 6.467632171106983, 1.9058593946122844, 1.4779550078506192], "isController": false}, {"data": ["Create User", 4000, 2, 0.05, 1058.8795, 0, 10042, 96.5, 3491.0, 4249.0, 5628.8399999999965, 6.9462895526068555, 2.410862756839056, 1.9672109084531135], "isController": false}, {"data": ["Update User", 3917, 3, 0.07658922644881287, 1615.0597395966265, 1, 10696, 1205.0, 3886.2000000000003, 4415.799999999999, 6050.82, 7.210746349985365, 2.471997479253227, 2.075365873007472], "isController": false}, {"data": ["Create Album", 3088, 0, 0.0, 658.4993523316064, 0, 10344, 5.0, 2668.1, 3552.649999999999, 4778.540000000002, 6.461440599943085, 2.0927010686590837, 1.6153601499857715], "isController": false}, {"data": ["Delete Genre", 4002, 1, 0.02498750624687656, 996.8285857071475, 1, 9476, 62.0, 3400.7000000000003, 4166.0, 5640.799999999992, 7.107754770028079, 1.3261218784799491, 1.4835469163764303], "isController": false}, {"data": ["Read Artist One", 4111, 0, 0.0, 728.2792507905627, 0, 8287, 6.0, 3101.0, 3367.7999999999993, 4794.280000000001, 6.331229083919972, 1.8532460254635226, 1.1793163671165725], "isController": false}, {"data": ["Read User", 3994, 0, 0.0, 1586.737105658488, 2, 13221, 762.5, 4364.5, 5055.25, 6818.750000000003, 7.054131718336327, 1273.6405040165191, 1.2675392931385587], "isController": false}, {"data": ["Read Artist", 4167, 0, 0.0, 759.1480681545468, 1, 10862, 101.0, 3058.0, 3592.2, 5036.5999999999985, 6.385981796810227, 254.06976644645093, 1.1599537248112326], "isController": false}, {"data": ["Delete Artist", 4027, 0, 0.0, 432.4447479513295, 0, 13505, 4.0, 1644.2000000000003, 3114.999999999999, 4461.199999999998, 6.354431138763924, 1.1852503393592866, 1.332536559774573], "isController": false}, {"data": ["Update Album", 2609, 154, 5.902644691452664, 219.7631276351092, 0, 6632, 3.0, 653.0, 1390.5, 3895.9, 5.857563980808564, 3.6400323713760674, 1.4906178857202514], "isController": false}, {"data": ["Delete Album", 2349, 21, 0.8939974457215837, 115.47083865474683, 1, 7264, 3.0, 49.0, 375.0, 3343.5, 5.3127728195918955, 1.4126100183877577, 1.1078944766330727], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["500", 27, 4.599659284497444, 0.030524685426158524], "isController": false}, {"data": ["404", 558, 95.05962521294718, 0.6308434988072762], "isController": false}, {"data": ["Test failed: code expected to contain /202/", 2, 0.34071550255536626, 0.002261087809345076], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 88453, 587, "404", 558, "500", 27, "Test failed: code expected to contain /202/", 2, null, null, null, null], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": [], "isController": false}, {"data": ["Update Playlist", 3534, 2, "500", 2, null, null, null, null, null, null, null, null], "isController": false}, {"data": ["Read Album One", 2765, 400, "404", 400, null, null, null, null, null, null, null, null], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["Read User One", 3980, 2, "Test failed: code expected to contain /202/", 2, null, null, null, null, null, null, null, null], "isController": false}, {"data": ["Create Genre", 4019, 1, "500", 1, null, null, null, null, null, null, null, null], "isController": false}, {"data": [], "isController": false}, {"data": ["Update Genre", 4004, 1, "404", 1, null, null, null, null, null, null, null, null], "isController": false}, {"data": [], "isController": false}, {"data": ["Create User", 4000, 2, "500", 2, null, null, null, null, null, null, null, null], "isController": false}, {"data": ["Update User", 3917, 3, "404", 2, "500", 1, null, null, null, null, null, null], "isController": false}, {"data": [], "isController": false}, {"data": ["Delete Genre", 4002, 1, "404", 1, null, null, null, null, null, null, null, null], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["Update Album", 2609, 154, "404", 154, null, null, null, null, null, null, null, null], "isController": false}, {"data": ["Delete Album", 2349, 21, "500", 21, null, null, null, null, null, null, null, null], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
