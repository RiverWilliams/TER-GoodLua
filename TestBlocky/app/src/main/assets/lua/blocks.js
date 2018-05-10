Blockly.Lua['allumer_led'] = function(block) {
  var value_red = Blockly.Lua.valueToCode(block, 'red', Blockly.Lua.ORDER_ATOMIC);
  var value_green = Blockly.Lua.valueToCode(block, 'green', Blockly.Lua.ORDER_ATOMIC);
  var value_blue = Blockly.Lua.valueToCode(block, 'blue', Blockly.Lua.ORDER_ATOMIC);
  // TODO: Assemble Lua into code variable.
  var code = 'nameFile = "./sh.sh"\n';
  code += ' file = io.open(nameFile, "a")\n';
  code += 'io.output(file)\n';
  code += 'if ' + value_red.length + ' != 0\n';
  code += 'then\n' +  value_red + '\n';
  code += 'end\n';
  code += 'if ' + value_green.length + ' != 0\n';
  code += 'then\n' + value_green + '\n';
  code += 'end\n';
  code += 'if ' + value_blue.length + ' != 0\n';
  code += 'then\n' + value_blue + '\n';
  code += 'end\n';
  code += 'io.close(file)\n';
  return code;
};

Blockly.Lua['pin'] = function(block) {
  var number_num_pin = block.getFieldValue('num_pin');
  var number_valeur_pin = block.getFieldValue('valeur_pin');
  // TODO: Assemble Lua into code variable.
  var code = 'lib.valeurGPIO(' + number_num_pin + ', ' + number_valeur_pin + ')\n'
  // TODO: Change ORDER_NONE to the correct strength.
  return [code, Blockly.Lua.ORDER_ATOMIC];
};

Blockly.Lua['allumer_moteur'] = function(block) {
  var value_numroue = Blockly.Lua.valueToCode(block, 'numRoue', Blockly.Lua.ORDER_ATOMIC);
  var value_puissanceroue = Blockly.Lua.valueToCode(block, 'puissanceRoue', Blockly.Lua.ORDER_ATOMIC);
  // TODO: Assemble Lua into code variable.
  var code = '...;\n';
  return code;
};

Blockly.Lua['avancer'] = function(block) {
  // TODO: Assemble Lua into code variable.
  var code = '...;\n';
  return code;
};

Blockly.Lua['reculer'] = function(block) {
  // TODO: Assemble Lua into code variable.
  var code = '...;\n';
  return code;
};

Blockly.Lua['initialisation'] = function(block) {
  // TODO: Assemble Lua into code variable.
  var code = 'local lib = require("library")\n';
  code += 'nameFile = "./sh.sh"\n';
  code += 'file = io.open(nameFile, "w")\n';
  code += 'io.output(file)\n';
  code += 'io.write("echo 1 | sudo tee /sys/class/gpio/export\n")\n';
  code += 'io.close(file)\n';
  return code;
};

Blockly.Lua['terminer'] = function(block) {
  // TODO: Assemble Lua into code variable.
  var code = 'os.execute("./sh.sh");\n';
  return code;
};

Blockly.Lua['allumer_led2'] = function(block) {
  var value_red2 = Blockly.Lua.valueToCode(block, 'red2', Blockly.Lua.ORDER_ATOMIC);
  var value_green2 = Blockly.Lua.valueToCode(block, 'green2', Blockly.Lua.ORDER_ATOMIC);
  var value_blue2 = Blockly.Lua.valueToCode(block, 'blue2', Blockly.Lua.ORDER_ATOMIC);
  // TODO: Assemble Lua into code variable.
  var code = '...;\n';
  return code;
};

Blockly.Lua['sleep'] = function(block) {
  var number_sleeptime = block.getFieldValue('sleeptime');
  // TODO: Assemble Lua into code variable.
  var code = 'lib.sleep(' + sleeptime + ')\n';
  return code;
};

Blockly.Lua['pin2'] = function(block) {
  var number_pin_number2 = block.getFieldValue('pin_number2');
  var number_pin_value2 = block.getFieldValue('pin_value2');
  // TODO: Assemble Lua into code variable.
  var code = '...';
  // TODO: Change ORDER_NONE to the correct strength.
  return [code, Blockly.Lua.ORDER_NONE];
};

Blockly.Lua['sensgpio'] = function(block) {
  var number_numpin = block.getFieldValue('numPin');
  var number_senspin = block.getFieldValue('sensPin');
  // TODO: Assemble Lua into code variable.
  var code = 'lib.sensGPIO(' + number_numpin + ', ' + number_senspin + ')\n';
  return code;
};

Blockly.Lua['valeurgpio'] = function(block) {
  var number_numpinvalue = block.getFieldValue('numPinvalue');
  var number_valuepin = block.getFieldValue('valuePin');
  // TODO: Assemble Lua into code variable.
  var code = 'lib.sensGPIO(' + number_numpinvalue + ', ' + number_valuepin + ')\n';
  return code;
};

Blockly.Lua['delay'] = function(block) {
  var number_delay = block.getFieldValue('delay');
  // TODO: Assemble Lua into code variable.
  var code = '...\n';
  return code;
};

Blockly.Lua['loop'] = function(block) {
  var number_times = block.getFieldValue('times');
  var statements_name = Blockly.Lua.statementToCode(block, 'NAME');
  // TODO: Assemble Lua into code variable.
  var code = '...;\n';
  return code;
};

Blockly.Lua['repeat2'] = function(block) {
  var number_times2 = block.getFieldValue('times2');
  var statements_name = Blockly.Lua.statementToCode(block, 'NAME');
  // TODO: Assemble Lua into code variable.
  var code = '...;\n';
  return code;
};