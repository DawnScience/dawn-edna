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
public class ControlIntegrationv10 extends AbstractEdnaPlugin {

	private final static Logger logger = LoggerFactory.getLogger(ControlIntegrationv10.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -8749832798743297984L;

	public ControlIntegrationv10(CompositeEntity container,
			String name) throws NameDuplicationException,
			IllegalActionException {
		super("EDPluginControlIntegrationv10", container, name);

	}

	@Override
	protected String getInputTagName() {
		return "XSDataInputIntegration";
	}

	@Override
	protected String getSchemaLocation() {
		return "/mxv1/datamodel/XSDataMXv1.xsd";
	}

	@Override
	protected String getPythonLocation() {
		return "mxv1/plugins/EDPluginControlIntegration-v1.0/plugins/EDPluginControlIntegrationv10.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "mxv1/plugins/EDPluginControlIntegration-v1.0/tests/data/XSDataIntegrationResult_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "MXv1 Integration";
	}

	@Override
	public String getDefaultInputXML() {

		final StringBuilder buf = new StringBuilder();

		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataIntegrationInput>\n");
		buf.append("    <dataCollection>\n");
		buf.append("      ${sub_wedges}\n");
		buf.append("    </dataCollection>\n");
		buf.append("    <selectedIndexingSolution>\n");
		buf.append("      ${selectedSolution_content}\n");
		buf.append("    </selectedIndexingSolution>\n");
		buf.append("    <experimentalConditionRefined>\n");
		buf.append("      ${experimentalConditionRefined_content}\n");
		buf.append("    </experimentalConditionRefined>\n");
		buf.append("</XSDataIntegrationInput>\n");

		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("file_dir", "");
		props.put("file_path", "");
		props.put("bestfilePar_content", "//bestfilePar/*");
		props.put("bestfileDat_content", "//bestfileDat/*");
		props.put("bestfileHKL_content", "//bestfileHKL/*");
		props.put("experimental_ConditionRefined_content", "//experimentalConditionRefined/*");
		return props;
	}

}
