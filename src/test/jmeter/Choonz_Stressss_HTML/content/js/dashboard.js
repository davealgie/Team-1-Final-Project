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

    var data = {"OkPercent": 81.50360534300012, "KoPercent": 18.496394656999882};
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
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.1907108239095315, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.18011454560768128, 500, 1500, "Read Genre"], "isController": false}, {"data": [0.2135225555795381, 500, 1500, "Update Playlist"], "isController": false}, {"data": [0.2116187384044527, 500, 1500, "Read Album One"], "isController": false}, {"data": [0.20904193514312877, 500, 1500, "Read Playlist One"], "isController": false}, {"data": [0.214010989010989, 500, 1500, "Delete Playlist"], "isController": false}, {"data": [0.1800774526678141, 500, 1500, "Read Genre One"], "isController": false}, {"data": [0.20545754668317343, 500, 1500, "Read Playlist"], "isController": false}, {"data": [0.20350417883395427, 500, 1500, "Create Playlist"], "isController": false}, {"data": [0.22304620650313747, 500, 1500, "Read Album"], "isController": false}, {"data": [0.19424149202076524, 500, 1500, "Read User One"], "isController": false}, {"data": [0.17807424593967516, 500, 1500, "Create Genre"], "isController": false}, {"data": [0.17504437631111827, 500, 1500, "Update Artist"], "isController": false}, {"data": [0.18372113520183325, 500, 1500, "Update Genre"], "isController": false}, {"data": [0.1634447065986757, 500, 1500, "Create Artist"], "isController": false}, {"data": [0.19039080459770116, 500, 1500, "Create User"], "isController": false}, {"data": [0.20095670184436334, 500, 1500, "Update User"], "isController": false}, {"data": [0.2197452229299363, 500, 1500, "Create Album"], "isController": false}, {"data": [0.18600252206809584, 500, 1500, "Delete Genre"], "isController": false}, {"data": [0.17082770135962472, 500, 1500, "Read Artist One"], "isController": false}, {"data": [0.14340030041306798, 500, 1500, "Read User"], "isController": false}, {"data": [0.16901792673421667, 500, 1500, "Read Artist"], "isController": false}, {"data": [0.17275924108603205, 500, 1500, "Delete Artist"], "isController": false}, {"data": [0.22369976359338062, 500, 1500, "Update Album"], "isController": false}, {"data": [0.23063932448733412, 500, 1500, "Delete Album"], "isController": false}]}, function(index, item){
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
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 253790, 46942, 18.496394656999882, 18553.18129161917, 0, 110861, 27393.0, 72271.80000000002, 74887.85, 78385.99, 135.40413431040142, 1457.5616661745423, 25.753257481733325], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["Read Genre", 11873, 1731, 14.579297565905836, 19008.086667228188, 1, 98228, 9546.0, 45642.4, 67141.49999999999, 88089.18000000001, 6.336440268656956, 101.84348559667967, 0.9780608827681165], "isController": false}, {"data": ["Update Playlist", 9266, 1965, 21.206561623138356, 18227.95791064103, 0, 101940, 7346.5, 45102.600000000006, 66171.34999999999, 87518.08999999998, 4.950942073550289, 3.266487689701068, 1.2462448665901174], "isController": false}, {"data": ["Read Album One", 8624, 2037, 23.62012987012987, 17655.724141929506, 0, 107244, 6348.0, 45126.5, 64261.0, 86251.0, 4.60713539710633, 13.099024074706485, 0.7384891356158705], "isController": false}, {"data": ["Read Playlist One", 9467, 1116, 11.788317312770678, 19083.646139220415, 0, 105209, 8645.0, 46591.80000000001, 66957.2, 87089.15999999996, 5.054174752616644, 7.7255767328847025, 0.8380907804154065], "isController": false}, {"data": ["Delete Playlist", 9100, 2140, 23.516483516483518, 17927.577692307663, 0, 101925, 6915.0, 45059.100000000006, 63983.19999999996, 88550.94, 4.8681168305242695, 3.5783025266128177, 0.8963182935605514], "isController": false}, {"data": ["Read Genre One", 11620, 1691, 14.55249569707401, 19030.419879518075, 0, 101616, 9827.0, 45539.299999999996, 67262.79999999993, 87584.03999999992, 6.203106357650186, 10.397966624271655, 0.980469782210644], "isController": false}, {"data": ["Read Playlist", 9693, 1151, 11.874548643350872, 19038.279480037134, 1, 100853, 8884.0, 46097.00000000001, 66005.29999999999, 85224.27999999998, 5.177201512407284, 104.27101432129415, 0.8376340368017681], "isController": false}, {"data": ["Create Playlist", 9931, 1183, 11.912194139562985, 18283.266740509458, 0, 99532, 8306.0, 44981.8, 59340.59999999999, 78543.48000000004, 5.302053124105735, 3.1603166628337873, 1.3229919061070512], "isController": false}, {"data": ["Read Album", 8765, 1172, 13.371363377067883, 17389.904734740525, 1, 106511, 6129.0, 44863.4, 63163.499999999905, 87125.3, 4.679286057862989, 77.13796257582152, 0.7324366030812285], "isController": false}, {"data": ["Read User One", 10402, 2126, 20.438377235147087, 17975.346760238448, 0, 102775, 8363.5, 43240.3, 58198.85000000002, 84572.59999999995, 5.553470438527695, 10.77121696854297, 0.8828938590493218], "isController": false}, {"data": ["Create Genre", 12068, 1773, 14.691746768312894, 18699.885316539552, 0, 107242, 9470.5, 45193.2, 65124.94999999998, 87304.29999999999, 6.44460512641957, 4.065551427306745, 1.4176717782581623], "isController": false}, {"data": ["Update Artist", 12394, 2926, 23.608197514926577, 18480.08294335968, 0, 101044, 8976.0, 44786.5, 62028.25, 87895.14999999998, 6.6162449793622695, 4.517843595223694, 1.304020191918615], "isController": false}, {"data": ["Update Genre", 11346, 2866, 25.260003525471532, 18292.876696633226, 0, 108198, 8381.0, 44935.20000000001, 64717.44999999999, 86542.54000000008, 6.056778696965151, 4.175993764490013, 1.3528460614122981], "isController": false}, {"data": ["Create Artist", 13139, 1526, 11.614278103356419, 21467.938808128423, 1, 105714, 15681.0, 48871.0, 70316.0, 88846.0, 7.015331320766, 3.7825394372117436, 1.4169228399651237], "isController": false}, {"data": ["Create User", 10875, 1555, 14.298850574712644, 17974.70685057482, 0, 101108, 8396.0, 43581.399999999994, 62498.59999999993, 84446.79999999997, 5.804872997385539, 3.7235904133656734, 1.4091933875423956], "isController": false}, {"data": ["Update User", 10139, 2360, 23.276457244304172, 17618.30653910642, 1, 106002, 8080.0, 43375.0, 54494.0, 76936.0000000001, 5.412142758009587, 3.5529212864915283, 1.3569010083045083], "isController": false}, {"data": ["Create Album", 8949, 1162, 12.984691026930383, 17866.221253771404, 0, 105227, 6721.0, 45131.0, 64263.0, 87314.0, 4.7796367924679455, 2.8533908652937163, 1.0397539306891244], "isController": false}, {"data": ["Delete Genre", 11102, 3042, 27.40046838407494, 17822.790938569615, 1, 101627, 8309.0, 43797.100000000006, 61566.45000000001, 86475.48999999992, 5.927056945552972, 4.751810830145667, 1.0506248523507757], "isController": false}, {"data": ["Read Artist One", 12577, 1875, 14.90816569929236, 19279.938141051145, 0, 102201, 10308.0, 44911.4, 64610.8999999999, 87010.09999999999, 6.713014237867123, 6.039838839887378, 1.06322077534327], "isController": false}, {"data": ["Read User", 10652, 1473, 13.828389034923019, 19029.811115283555, 3, 106791, 9258.5, 44894.7, 64211.100000000035, 87842.27999999998, 5.687889100045868, 982.6783722432267, 0.8807105496139103], "isController": false}, {"data": ["Read Artist", 12830, 1756, 13.686671862821512, 20157.268823070935, 0, 102763, 11752.0, 46720.59999999999, 67667.99999999997, 88958.81000000003, 6.846475132567075, 85.01783112719501, 1.073390841545457], "isController": false}, {"data": ["Delete Artist", 12228, 3218, 26.316650310762185, 18357.440219169126, 1, 110100, 9414.0, 44647.9, 61275.14999999998, 86593.13, 6.52683190845782, 5.497725726942717, 1.1556915064782596], "isController": false}, {"data": ["Update Album", 8460, 2513, 29.70449172576832, 17425.273167848718, 1, 110861, 5821.5, 45128.100000000006, 66254.5, 88320.4199999999, 4.520996179597909, 5.352048300010581, 0.9986168017866486], "isController": false}, {"data": ["Delete Album", 8290, 2585, 31.182147165259348, 16818.388057901153, 1, 101266, 5508.5, 44428.000000000044, 61715.85, 86926.59000000004, 4.43293935963544, 7.433099909142123, 0.8018164498746319], "isController": false}]}, function(index, item){
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
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 27327, 58.214392228707766, 10.767563733795658], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 22, 0.04686634570320822, 0.008668584262579299], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 7208, 15.355119083123855, 2.84014342566689], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 104, 0.22154999786971155, 0.04097876196855668], "isController": false}, {"data": ["500", 2101, 4.475736014656384, 0.8278497970763229], "isController": false}, {"data": ["404", 9468, 20.169570959907972, 3.730643445368218], "isController": false}, {"data": ["Test failed: code expected to contain /202/", 712, 1.5167653700311021, 0.2805469088616573], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 253790, 46942, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 27327, "404", 9468, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 7208, "500", 2101, "Test failed: code expected to contain /202/", 712], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["Read Genre", 11873, 1731, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1364, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 360, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 5, "500", 2, null, null], "isController": false}, {"data": ["Update Playlist", 9266, 1965, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 911, "404", 812, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 239, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 2, "500", 1], "isController": false}, {"data": ["Read Album One", 8624, 2037, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 911, "404", 884, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 239, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 1], "isController": false}, {"data": ["Read Playlist One", 9467, 1116, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 846, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 264, "404", 3, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 1], "isController": false}, {"data": ["Delete Playlist", 9100, 2140, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 911, "404", 720, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 257, "500", 250, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 2], "isController": false}, {"data": ["Read Genre One", 11620, 1691, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1341, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 347, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 1, "404", 1], "isController": false}, {"data": ["Read Playlist", 9693, 1151, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 879, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 266, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, null, null], "isController": false}, {"data": ["Create Playlist", 9931, 1183, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 964, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 215, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 2, "500", 2, null, null], "isController": false}, {"data": ["Read Album", 8765, 1172, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 940, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 227, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 2, "500", 1], "isController": false}, {"data": ["Read User One", 10402, 2126, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1146, "Test failed: code expected to contain /202/", 712, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 255, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 11, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1], "isController": false}, {"data": ["Create Genre", 12068, 1773, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1424, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 343, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 2, "500", 2], "isController": false}, {"data": ["Update Artist", 12394, 2926, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1497, "404", 1022, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 398, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 5, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 3], "isController": false}, {"data": ["Update Genre", 11346, 2866, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1325, "404", 1192, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 345, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4, null, null], "isController": false}, {"data": ["Create Artist", 13139, 1526, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1108, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 414, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4, null, null, null, null], "isController": false}, {"data": ["Create User", 10875, 1555, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1245, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 302, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, "500", 2], "isController": false}, {"data": ["Update User", 10139, 2360, "404", 1066, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1029, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 259, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 6, null, null], "isController": false}, {"data": ["Create Album", 8949, 1162, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 903, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 251, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 8, null, null, null, null], "isController": false}, {"data": ["Delete Genre", 11102, 3042, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1287, "404", 1059, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 364, "500", 328, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4], "isController": false}, {"data": ["Read Artist One", 12577, 1875, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1463, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 399, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 9, "404", 3, "500", 1], "isController": false}, {"data": ["Read User", 10652, 1473, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1197, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 266, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 8, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, null, null], "isController": false}, {"data": ["Read Artist", 12830, 1756, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1338, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 405, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 9, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4, null, null], "isController": false}, {"data": ["Delete Artist", 12228, 3218, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 1504, "404", 926, "500", 404, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 380, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4], "isController": false}, {"data": ["Update Album", 8460, 2513, "404", 1399, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 899, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 211, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4, null, null], "isController": false}, {"data": ["Delete Album", 8290, 2585, "500", 1105, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to 127.0.0.1:8082 [/127.0.0.1] failed: Connection refused: connect", 895, "404", 381, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: 127.0.0.1:8082 failed to respond", 202, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 2], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
