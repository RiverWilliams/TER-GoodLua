Blockly.Lua['allumer_led'] = function(block) {
  var value_red = Blockly.Lua.valueToCode(block, 'red', Blockly.Lua.ORDER_ATOMIC);
  var value_green = Blockly.Lua.valueToCode(block, 'green', Blockly.Lua.ORDER_ATOMIC);
  var value_blue = Blockly.Lua.valueToCode(block, 'blue', Blockly.Lua.ORDER_ATOMIC);
  // TODO: Assemble Lua into code variable.
  var code = 'print("A")';
  return code;
};

Blockly.Lua['pin'] = function(block) {
  var number_num_pin = block.getFieldValue('num_pin');
  var number_valeur_pin = block.getFieldValue('valeur_pin');
  // TODO: Assemble Lua into code variable.
  var code = 'print("B")';
  // TODO: Change ORDER_NONE to the correct strength.
  return [code, Blockly.Lua.ORDER_NONE];
};

Blockly.Lua['allumer_moteur'] = function(block) {
  var value_numroue = Blockly.Lua.valueToCode(block, 'numRoue', Blockly.Lua.ORDER_ATOMIC);
  var value_puissanceroue = Blockly.Lua.valueToCode(block, 'puissanceRoue', Blockly.Lua.ORDER_ATOMIC);
  // TODO: Assemble Lua into code variable.
  var code = 'print("C")';
  return code;
};

Blockly.Lua['avancer'] = function(block) {
  // TODO: Assemble Lua into code variable.
  var code = 'print("D")';
  return code;
};

Blockly.Lua['reculer'] = function(block) {
  // TODO: Assemble Lua into code variable.
  var code = 'print("E")';
  return code;
};