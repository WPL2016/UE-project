Grid = function(config) {
  this.titleTable = $('#'+config.titleTable);
  this.dataTable = $('#'+config.dataTable);
  this.widths = config.widths;
  this.height = config.height;
  this.init();
}

Grid.prototype = {
  
  init : function() {
    var entity = this;
    
    this.titleTable.wrap('<DIV class="tableColumn"></DIV>');
    this.titleDiv = this.titleTable.parent();
    
    this.dataTable.wrap('<DIV class="tableContent"></DIV>');
    this.dataDiv = this.dataTable.parent();
    
		this.updateHeight();
		
    this.updateWidth();
      
  },
  updateAll : function() {
		this.updateHeight();
    this.updateWidth();
  },
  updateWidth : function() {
    var entity = this;
    
    //更新第一列的宽度
    var dataTableTdsFirst = this.dataTable.find('tr.row:first td');
    dataTableTdsFirst.each(function(i){
      if(entity.widths[i])
        $(this).width(entity.widths[i]);
    });

    //隔行变色
	var dataTableTrs = this.dataTable.find('tr.row');
	dataTableTrs.each(function(i){
	  if((i+1)%2==0)
		$(this).addClass('high');
	});
		
    //设置表头宽度
    var titleTableTds = this.titleTable.find('tr td');
    titleTableTds.each(function(i){
      $(this).width(entity.widths[i]);
    });
		
    //更新表格宽度(判断是否需要显示滚动条)
    if(this.dataDiv.get(0).clientHeight < this.dataDiv.get(0).scrollHeight) {
      this.titleTable.width(this.titleDiv.width()-15);
      this.dataTable.width(this.titleDiv.width()-15);
      //如果显示滚动条,则需要再次更新第一列宽度
      dataTableTdsFirst.each(function(i){
        if(entity.widths[i])
          $(this).width(entity.widths[i]);
        else//取表头的字段宽度
          $(this).width(titleTableTds.eq(i).width());
      });
    } else {
      this.titleTable.width(this.titleDiv.width());
      this.dataTable.width(this.titleDiv.width());
    }
  },
  updateHeight : function() {
    switch(typeof(this.height)) {
      case 'number' : this.dataDiv.height(this.height-this.titleTable.get(0).offsetHeight);break;
      case 'function' : this.dataDiv.height(this.height());break;
    }
  }
  
};