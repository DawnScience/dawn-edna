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
 * EdnaPluginTransformer, copied from delay action.
 * 
 * @author svensson
 * @date Feb 15, 2011
 * @project org.edna.passerelle.actors
 **/
public class ControlStrategyv1_2 extends AbstractEdnaPlugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7823020490489403315L;

	private final static Logger logger = LoggerFactory.getLogger(ControlStrategyv1_2.class);

	/**
	 * 
	 */

	public ControlStrategyv1_2(CompositeEntity container, String name)
			throws NameDuplicationException, IllegalActionException {
		super("EDPluginControlStrategyv1_2", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputStrategy";
	}


	@Override
	protected String getSchemaLocation() {
		return "/mxv1/datamodel/XSDataMXv1.xsd";
	}

	@Override
	protected String getPythonLocation() {
		return "mxv1/plugins/EDPluginControlStrategy-v1.2/plugins/EDPluginControlStrategyv1_2.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "mxv1/plugins/EDPluginControlStrategy-v1.2/tests/data/XSDataInputStrategy_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "MXv1 Strategy Calculation";
	}

	@Override
	public String getDefaultInputXML() {

		final StringBuilder buf = new StringBuilder();

		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataInputStrategy>\n");
		buf.append("  <bestFileContentPar>\n");		
		buf.append("    ${bestfilePar_content}\n");
		buf.append("  </bestFileContentPar>\n");		
		buf.append("  <bestFileContentDat>\n");		
		buf.append("    ${bestfileDat_content}\n");
		buf.append("  </bestFileContentDat>\n");		
		buf.append("  <bestFileContentHKL>\n");		
		buf.append("    ${bestfileHKL_content}\n");
		buf.append("  </bestFileContentHKL>\n");		
		buf.append("  <experimentalCondition>\n");		
		buf.append("    ${experimentalConditionRefined_content}\n");
		buf.append("  </experimentalCondition>\n");		
		buf.append("  <diffractionPlan>\n");		
		buf.append("    <maxExposureTimePerDataCollection>\n");		
		buf.append("      <value>600</value>\n");		
		buf.append("    </maxExposureTimePerDataCollection>\n");		
		buf.append("  </diffractionPlan>\n");		
		buf.append("  <crystalRefined>\n");		
		buf.append("    ${crystal_content}\n");		
		buf.append("  </crystalRefined>\n");		
		buf.append("</XSDataInputStrategy>\n");
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("log_path", "//bestLogFile/path/value/text()");
		return props;
	}

}
