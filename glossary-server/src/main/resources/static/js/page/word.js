const WordManager = function() {
	const name = "단어";
	
	const DataTable = {
		ele: "#wordTable",
		table: null,
		option: {
			columns: [
				{ data: "name" },
				{ data: "name" },
				{ data: "name" },
				{
					width: "10%",
					render: function(data, type, row, meta) {
						return '<button type="button" class="btn btn-outline bg-primary text-primary-600 btn-sm"'
						+ 'onClick="WordManager.modal(' + row.id + ')"><i class="icon-pencil7"></i></button>'
						+ '<button type="button" class="btn btn-outline bg-danger text-danger-600 btn-sm" '
						+ 'onClick="WordManager._delete(' + row.id + ')"><i class="icon-trash"></i></button>';
					}
				}
				]
		},
		init: function() {
			this.table = Datatables.order(this.ele, this.option);
			this.search();
		},
		search: function() {
			var param = new Object();
			param.name = $("input[name=name]").val();
			Datatables.rowsAdd(this.table, contextPath + "/word/search", param);
		}
	}
	
	const Control = function() {
		$("#searchBtn").click(function() {
			DataTable.search();
		});

		$('#updateForm').submit(function(e) {
			e.preventDefault();
			var form = $(this);
			var url = form.attr('action');
			
		 	updateModalCommon(url, form.serializeObject(), name, DataTable, "updateModal");
		}); 
	}
	
	return {
		init: function() {
			DataTable.init();
			Control();
		},
		_delete: function(id) {
			deleteCommon(contextPath + "/word/delete", id, name, DataTable);
		},
		modal: function(id) {
			$.ajax({
	    		url: contextPath + "/word/get",
	    		type: "GET",
	    		data: {"id": id},
	    		success: function(response) {
	    			$('#updateForm input[name="id"]').val(response.id);
	    			$('#updateForm input[name="name"]').val(response.name);
	    			$("#updateModal").modal();
	           	}
	    	}); 
		}
	}
}();

$(document).ready(function() {
	WordManager.init();
});
