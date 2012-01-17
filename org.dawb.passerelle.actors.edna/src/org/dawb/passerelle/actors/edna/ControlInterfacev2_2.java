/*
 * Copyright (c) 2012 European Synchrotron Radiation Facility,
 *                    Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.dawb.passerelle.actors.edna;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

/**
 * ControlInterfacev2_2
 * 
 * @author svensson
 * @date June 27, 2011
 * @project org.dawb.passerelle.actors
 **/
public class ControlInterfacev2_2 extends AbstractEdnaPlugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5459580374931695905L;
	
	private final static Logger logger = LoggerFactory.getLogger(ControlInterfacev2_2.class);

	public ControlInterfacev2_2(CompositeEntity container, String name)
			throws NameDuplicationException, IllegalActionException {
		super("EDPluginControlInterfacev2_2", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputInterfacev2_2";
	}

	@Override
	protected String getSchemaLocation() {
		return "mxv2/plugins/EDPluginGroupInterface-v2.2/datamodel/XSDataInterfacev2_2.edml";
	}

	@Override
	protected String getPythonLocation() {
		return "mxv2/plugins/EDPluginGroupInterface-v2.2/plugins/EDPluginControlInterfacev2_2.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "mxv2/plugins/EDPluginGroupInterface-v2.2/tests/data/XSDataResultInterfacev2_2_kappaCELL.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "MXv2 Interface v2.2";
	}

	@Override
	public String getDefaultInputXML() {

		final StringBuilder buf = new StringBuilder();

		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataInputInterfacev2_2>\n");
		buf.append("  <diffractionPlan>\n");
		buf.append("    <kappaStrategyOption>\n");
		buf.append("      <value>${kappaStrOpt}</value>\n");
		buf.append("    </kappaStrategyOption>\n");
		buf.append("  </diffractionPlan>\n");
		buf.append("  <imagePath>\n");
		buf.append("    <path>\n");
		buf.append("      <value>${directory}/RAW_DATA/${prefix}_${run_number}_0001.${suffix}</value>\n");
		buf.append("    </path>\n");
		buf.append("  </imagePath>\n");
		buf.append("  <imagePath>\n");
		buf.append("    <path>\n");
		buf.append("      <value>${directory}/RAW_DATA/${prefix}_${run_number}_0002.${suffix}</value>\n");
		buf.append("    </path>\n");
		buf.append("  </imagePath>\n");
		buf.append("  <omega>\n");
		buf.append("    <value>${phi}</value>\n");
		buf.append("  </omega>\n");
		buf.append("  <kappa>\n");
		buf.append("    <value>${kap1}</value>\n");
		buf.append("  </kappa>\n");
		buf.append("  <phi>\n");
		buf.append("    <value>${kap2}</value>\n");
		buf.append("  </phi>\n");
		buf.append("</XSDataInputInterfacev2_2>\n");
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("suggestedStrategyComment", "//suggestedStrategy/collectionPlan/comment/value/text()");
		props.put("suggestedStrategy", "//suggestedStrategy");
		props.put("mxv1ResultCharacterisation", "//mxv1ResultCharacterisation");
		props.put("mxv1ResultCharacterisation_Reference", "//mxv1ResultCharacterisation_Reference");
		props.put("predictionImagePath", "//mxv1ResultCharacterisation/indexingResult/predictionResult/predictionImage/path/value/text()");
		props.put("possibleOrientations", "//possibleOrientations");
		props.put("mxv1ShortSummary", "//mxv1ResultCharacterisation/shortSummary");
		props.put("mxv1StrategyResult", "//mxv1ResultCharacterisation/strategyResult");
		props.put("mxv2DataCollection", "//mxv2DataCollection");
		props.put("mxv2DataCollection_Reference", "//mxv2DataCollection_Reference");
	return props;
	}

}
