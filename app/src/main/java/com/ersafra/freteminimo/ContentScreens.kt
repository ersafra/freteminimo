package com.ersafra.freteminimo


import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TabelaScreen() {
    Column(
        modifier = Modifier.run {
            fillMaxSize()
                .wrapContentSize(Alignment.Center)
        }
    ) {
        FormTabela()
    }
}

@Composable
fun FracaoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(colorResource(id = R.color.colorPrimaryDark))
            .wrapContentSize(Alignment.Center)
    ) {

    }

}

@Composable
fun DiariasScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        fun SearchBar(
            modifier: Modifier = Modifier
        ) {
        }
    }
}
//@Composable
//fun BannerAdView() {
//    AndroidView(
//        modifier = Modifier
//            .fillMaxWidth(),
//        factory = { context ->
//            AdView(context).apply {
//                setAdSize(AdSize.MEDIUM_RECTANGLE)
//                adUnitId = "ca-app-pub-2741955499317480/2875000844"
//                loadAd(AdRequest.Builder().build())
//            }
//        }
//    )
//}

//formulario da tabela --//
@Composable
fun FormTabela() {
    var origem by remember { mutableStateOf("") }
    var destino by remember { mutableStateOf("") }
    var distanciakm by remember { mutableStateOf("") }
    var numeroeixos by remember { mutableStateOf("") }
    var tipodefrete by remember { mutableStateOf("") }
    var tipodecarga by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = origem,
            onValueChange = { origem = it },
            label = { Text("Origem") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = destino,
            onValueChange = { destino = it },
            label = { Text("Destino") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = distanciakm,
            onValueChange = { distanciakm = it },
            label = { Text("Distancia(km)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = numeroeixos,
            onValueChange = { numeroeixos = it },
            label = { Text("Número de Eixos") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = tipodefrete,
            onValueChange = { tipodefrete = it },
            label = { Text("Tipo de Frete") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = tipodecarga,
            onValueChange = { tipodecarga = it },
            label = { Text("Tipo de Carga") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(
            onClick = { /* Do something */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Submit")
        }
    }
}



