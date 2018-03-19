function connect(){
	//var action = document.getElementById("action").value;
	console.log("connect");
	var params = document.getElementById("uri").value;
	$.ajax({
		url:"/connect",
		type:'POST',
		dataType:"text",
		data:{'uri':params},
		success:function(result){
			$("#result").html(result);
		},
		error:function(result){
		}
	});
}

function send(){
	console.log("send");
	var params = document.getElementById("message").value;
	$.ajax({
		url:"/send",
		type:'POST',
		dataType:"text",
		data:{'text':params},
		success:function(result){
			$("#result").html(result);
		},
		error:function(result){
		}
	});
}

function close(){
	$.ajax({
		url:"/close",
		type:'GET',
		success:function(result){
			$("#result").html(result);
		},
		error:function(result){
		}
	});
	var ws;
	function wsconnect(){
		var uri = document.getElementById("uri").value;
		var ws = new WebSocket(uri);document.
		//var message = document.getElementById("message").value;
		ws.addEvnetListener("message" function(e){console.log(e);})
		//ws.send(message)
		
	}

	function wssend(){
		//var uri = document.getElementById("uri").value;
		//var ws2 = new WebSocket(uri)
		var message = document.getElementById("message").value;
		//ws.addEvnetListener("message" function(e){console.log(e);})
		ws.send(message)
		
	}
}

