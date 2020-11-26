document.onload = axios.get('https://5e74cb4b9dff120016353b04.mockapi.io/api/v1/blacklist')
		.then(response => {
			console.log(response);
		})
		.catch(err => {
			console.log(err);
		});