package com.ersafra.freteminimo


import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
FormDiarias()
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
       horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Qual a cidade da coleta?",
            modifier = Modifier.padding(1.dp),
            style = TextStyle(fontWeight = FontWeight.Bold))
        OutlinedTextField(
            value = origem,
            onValueChange = { origem = it },
            label = { Text("Origem") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Qual a cidade da entrega?",
            modifier = Modifier.padding(1.dp),
            style = TextStyle(fontWeight = FontWeight.Bold))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
        OutlinedTextField(
            value = destino,
            onValueChange = { destino = it },
            label = { Text("Destino") },
            //modifier = Modifier.fillMaxWidth()
        )
            Spacer(modifier = Modifier.width(1.dp))
            OutlinedButton(
                onClick = { /* ação do botão */ },
                modifier = Modifier.wrapContentWidth()
            ) {
                Text("Mapa")
            }
        }
        Text(text = "Qual a distancia percorrida na rota?",
            modifier = Modifier.padding(1.dp),
            style = TextStyle(fontWeight = FontWeight.Bold))
        OutlinedTextField(
            value = distanciakm,
            onValueChange = { distanciakm = it },
            label = { Text("Kms 0.00") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Quantos eixos tem o conjunto?",
            modifier = Modifier.padding(1.dp),
            style = TextStyle(fontWeight = FontWeight.Bold))
        OutlinedTextField(
            value = numeroeixos,
            onValueChange = { numeroeixos = it },
            label = { Text("Eixos") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Qual o tipo de frete?",
            modifier = Modifier.padding(1.dp),
            style = TextStyle(fontWeight = FontWeight.Bold))
        OutlinedTextField(
            value = tipodefrete,
            onValueChange = { tipodefrete = it },
            label = { Text("Frete") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Qual o tipo de carga?",
            modifier = Modifier.padding(1.dp),
            style = TextStyle(fontWeight = FontWeight.Bold))
        OutlinedTextField(
            value = tipodecarga,
            onValueChange = { tipodecarga = it },
            label = { Text("Carga") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedButton(
            onClick = { /* Do something */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .align(CenterHorizontally)
        ) {
            Text(stringResource(id = R.string.btnCalcular))
        }
    }
}

@Composable
private fun FormDiarias() {
    var textState by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Digite algo...") },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(10.dp)) // espaçamento entre os widgets
        OutlinedButton(
            onClick = { /* ação do botão */ },
            modifier = Modifier.wrapContentWidth()
        ) {
            Text("Mapa")
        }
    }

}


