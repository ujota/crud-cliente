var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "nome": "João Pedro",
  "email": "joao.silveerio@gmail.com",
  "telefone": "11972247142",
  "cpf": "45495488820",
  "dataNascimento": "1997-01-31"
});

var requestOptions = {
  method: 'DELETE',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("localhost:8080/cliente", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));