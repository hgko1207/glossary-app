const TermManager = function() {
	const name = "용어";
	
	const DataTable = {
		ele: "#termTable",
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
						+ 'onClick="TermManager.modal(' + row.id + ')"><i class="icon-pencil7"></i></button>'
						+ '<button type="button" class="btn btn-outline bg-danger text-danger-600 btn-sm" '
						+ 'onClick="TermManager._delete(' + row.id + ')"><i class="icon-trash"></i></button>';
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
			Datatables.rowsAdd(this.table, contextPath + "/term/search", param);
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
			deleteCommon(contextPath + "/term/delete", id, name, DataTable);
		},
		modal: function(id) {
			$.ajax({
	    		url: contextPath + "/term/get",
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
	TermManager.init();
});
