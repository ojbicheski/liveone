function success(data, textStatus, jqXHR) {
	$('#modalMessageTitle').remove();
	$('#modalMessageTitle').html('Sucesso!');
	$('#message p').remove();
	$('#message').append('<p>Código:'+data.code+'</p>');
	$('#message').append('<p>Mensagem:'+data.message+'</p>');
}

function failure(data, textStatus, jqXHR) {
	$('#modalMessageTitle').remove();
	$('#modalMessageTitle').html('Falhou!');
	$('#message p').remove();
	$('#message').append('<p>Código:'+data.code+'</p>');
	$('#message').append('<p>Mensagem:'+data.message+'</p>');
}
