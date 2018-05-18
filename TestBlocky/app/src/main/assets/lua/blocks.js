Blockly.Lua['allumer_led'] = function(block) {
  var value_red = Blockly.Lua.valueToCode(block, 'red', Blockly.Lua.ORDER_ATOMIC);
  var value_green = Blockly.Lua.valueToCode(block, 'green', Blockly.Lua.ORDER_ATOMIC);
  var value_blue = Blockly.Lua.valueToCode(block, 'blue', Blockly.Lua.ORDER_ATOMIC);
  var code = 'if ' + value_red.length + ' ~= 0\n';
  code += 'then\n' +  value_red + '\n';
  code += 'end\n';
  code += 'if ' + value_green.length + ' ~= 0\n';
  code += 'then\n' + value_green + '\n';
  code += 'end\n';
  code += 'if ' + value_blue.length + ' ~= 0\n';
  code += 'then\n' + value_blue + '\n';
  code += 'end\n';
  return code;
};

Blockly.Lua['pin'] = function(block) {
  var number_num_pin = block.getFieldValue('num_pin');
  var number_valeur_pin = block.getFieldValue('valeur_pin');
  var code = 'lib.valeurGPIO(' + number_num_pin + ', ' + number_valeur_pin + ')\n';
  return [code, Blockly.Lua.ORDER_ATOMIC];
};

Blockly.Lua['allumer_moteur'] = function(block) {
 var value_numroue = block.getFieldValue('numRoue');
  var value_puissanceroue = block.getFieldValue('puissanceRoue');
  var code = 'if ' + value_numroue.length + ' != 0 && ' + value_puissanceroue.length + ' != 0 \n';
  code += 'digitalWrite(' + value_numroue + ',LOW);\n';
  code += 'pinMode(' + value_numroue + ', OUTPUT);\n';
  code += 'analogWrite(' + value_numroue + ', ' + value_puissanceroue + ');\n';
  return code;
};

Blockly.Lua['avancer'] = function(block) {
  var code = 'analogWrite (E1,155);\n';  
  code += 'digitalWrite(M1,LOW);\n';
  code += 'analogWrite (E2,155);\n';
  code += 'digitalWrite(M2,LOW);\n';
  return code;
};

Blockly.Lua['reculer'] = function(block) {
  var code = 'analogWrite (E1,155);\n';
  code += 'digitalWrite(M1,HIGH);\n';
  code += 'analogWrite (E2,155);\n';
  code += 'digitalWrite(M2,HIGH);\n';
  return code;
};

Blockly.Lua['allumer_led2'] = function(block) {
  var value_red2 = Blockly.Lua.valueToCode(block, 'red2', Blockly.Lua.ORDER_ATOMIC);
  var value_green2 = Blockly.Lua.valueToCode(block, 'green2', Blockly.Lua.ORDER_ATOMIC);
  var value_blue2 = Blockly.Lua.valueToCode(block, 'blue2', Blockly.Lua.ORDER_ATOMIC);
  var code = 'if (' + value_red2.length + ' != 0) {\n';
  code += value_red2 + '\n';
  code += '}\n';
  code += 'if (' + value_green2.length + ' != 0){\n';
  code += value_green2 + '\n';
  code += '}\n';
  code += 'if (' + value_blue2.length + ' != 0){\n';
  code += value_blue2 + '\n';
  code += '}\n';
  return code;
};

Blockly.Lua['sleep1'] = function(block) {
  var number_sleeptime = block.getFieldValue('sleeptime');
  var code = 'lib.sleep(' + number_sleeptime + ')\n';
  return code;
};

Blockly.Lua['pin2'] = function(block) {
  var number_pin_number2 = block.getFieldValue('pin_number2');
  var number_pin_value2 = block.getFieldValue('pin_value2');
  var code = 'pinMode(' + number_pin_number2 + ', OUTPUT);\n';
  code += 'if('+number_pin_value2 + ' == 1){ \n';
  code +=  'digitalWrite(' + number_pin_number2 + ', HIGH);\n';
  code += '}\n';
  code += 'else {\n';
  code += 'digitalWrite(' + number_pin_number2 + ', LOW);\n'
  code += '}\n';
  return [code, Blockly.Lua.ORDER_ATOMIC];
};

Blockly.Lua['sensgpio'] = function(block) {
  var number_numpin = block.getFieldValue('numPin');
  var number_senspin = block.getFieldValue('sensPin');
  var code = 'lib.sensGPIO(' + number_numpin + ', ' + number_senspin + ')\n';
  return code;
};

Blockly.Lua['valeurgpio'] = function(block) {
  var number_numpinvalue = block.getFieldValue('numPinvalue');
  var number_valuepin = block.getFieldValue('valuePin');
  var code = 'lib.valeurGPIO(' + number_numpinvalue + ', ' + number_valuepin + ')\n';
  return code;
};

Blockly.Lua['delay'] = function(block) {
  var number_delay = block.getFieldValue('delay');
  var code = 'delay(' + number_delay + ');\n';
  return code;
};

Blockly.Lua['loop'] = function(block) {
  var number_times = block.getFieldValue('times');
  var statements_name = Blockly.Lua.statementToCode(block, 'statementLoop');
  var code = 'for i=1,' + number_times +' do\n';
  code += statements_name + '\n';
  code += 'end\n';
  return code;
};

Blockly.Lua['repeat2'] = function(block) {
  var number_times2 = block.getFieldValue('times2');
  var statements_name = Blockly.Lua.statementToCode(block, 'statementRepeat');
  var code = 'for (int i=0; i <= ' + number_times2 + '; i++){\n';
  code += statements_name + '\n';
  code += '};\n';
  return code;
};

Blockly.Lua['initialiser'] = function(block) {
  var code = 'local lib = require("library")\n';
  code += 'nameFile = "./sh.sh"\n';
  code += 'file = io.open(nameFile, "w")\n';
  code += 'io.output(file)\n';
  code += 'io.write("")\n';
  code += 'io.close(file)\n';
  return code;
};

Blockly.Lua['terminer'] = function(block) {
  var code = 'os.execute("./sh.sh");\n';
  return code;
};

Blockly.Lua['initialiser2'] = function(block) {
  var code = 'int E1 = 5;\n';   
  code += 'int E2 = 6;\n';     
  code += 'int M1 = 4;\n';    
  code += 'int M2 = 7;\n';
  code += 'void setup(void) {\n';
  code += 'for(int i=4;i<=7;i++){\n';
  code += 'pinMode(i, OUTPUT);\n';
  code += '}\n';
  code += 'Serial.begin(19200);\n';
  code += '}\n';
  code += '\n';
  code += 'void loop() {\n';
  return code;
};

Blockly.Lua['terminer2'] = function(block) {
  var code = '}\n';
  return code;
};

Blockly.Lua['stoproues'] = function(block) {
  var code = 'digitalWrite(E1,LOW);\n';
  code += 'digitalWrite(E2,LOW);\n';
  return code;
};

Blockly.Lua['gauche'] = function(block) {
  var code = 'analogWrite (E1,50);\n';
  code += 'digitalWrite(M1,LOW);\n';
  code += 'analogWrite (E2,200);\n';
  code += 'digitalWrite(M2,LOW);\n';
  return code;
};

Blockly.Lua['droite'] = function(block) {
  var code = 'analogWrite (E1,200);\n';
  code += 'digitalWrite(M1,LOW);\n';
  code +='analogWrite (E2,50);\n';
  code +='digitalWrite(M2,LOW);\n';
  return code;
};