var App = {};

App.init = function( ctxPath ) {
    this.__ctxPath = ctxPath;  
};

App.loadList = function( selector, cols ) {
    $.ajax({
        type    : 'GET',
        url     : this.__ctxPath + '/services/employee',
        success : function(resp){
            var obj = eval('(' +resp+ ')');
            render( obj );
        }
    });  
    
    //helpers
    function render( obj ) {
        var tbl = $(selector).empty();
        
        var header = $('<tr></tr>');
        $(cols).each(function(i,c){
            $('<th></th>').html(c.caption).appendTo(header);
        });
        $('<thead></thead>').append(header).appendTo(tbl);
        
        var tbody = $('<tbody></tbody>');
        $(obj).each(function(i,item){
            var tr = $('<tr></tr>').append( buildCols(item) ).appendTo(tbody);
        });
        tbody.appendTo(tbl);
    }
    
    function buildCols( item ) {
        var tds = [];
        $(cols).each(function(i,c){
            var e = item[c.name];
            tds.push($('<td></td>').html(e));
        });
        return tds;
    }
};

App.submit = function(form) {
    $.ajax({
        type: 'POST',
        data: $(form).serialize(),
        url:  App.__ctxPath + '/services/employee',
        success: function(resp) {
            alert( resp );
        }
    });
};